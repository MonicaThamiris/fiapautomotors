package br.com.fiap.fiapautomotors.adapters.out.integration;

import br.com.fiap.fiapautomotors.core.port.out.ClienteIntegracaoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminCreateUserRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminSetUserPasswordRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.MessageActionType;

@Component
@AllArgsConstructor
public class ClienteIntegracaoCognito implements ClienteIntegracaoPort {

    private final CognitoIdentityProviderClient cognitoClient;

    private final String userPoolId = "us-east-1_cfdHUmyXF";

    @Override
    public String cadastrar(String email, String senha) {
        cognitoClient.adminCreateUser(AdminCreateUserRequest.builder()
                .userPoolId(userPoolId)
                .username(email)
                .userAttributes(
                        AttributeType.builder().name("email").value(email).build(),
                        AttributeType.builder().name("email_verified").value("true").build()
                )
                .messageAction(MessageActionType.SUPPRESS)
                .build());

        cognitoClient.adminSetUserPassword(AdminSetUserPasswordRequest.builder()
                .userPoolId(userPoolId)
                .username(email)
                .password(senha)
                .permanent(true)
                .build());

        var user = cognitoClient.adminGetUser(builder -> builder
                .userPoolId(userPoolId)
                .username(email));

        return user.userAttributes().stream()
                .filter(attr -> "sub".equals(attr.name()))
                .map(AttributeType::value)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("sub não encontrado no Cognito"));
    }
}
