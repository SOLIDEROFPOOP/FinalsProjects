export const oktaConfig = {
    clientId : '0oadygtaodQcN2aR25d7',
    issuer: 'https://dev-54263899.okta.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes:['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true,
    maxClockSkew: 60000,
}   