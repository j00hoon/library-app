export const oktaConfig = {
    clientId: '0oad76bgwwHnaDBvp5d7',
    issuer: 'https://dev-77126434.okta.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scope: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true,
}