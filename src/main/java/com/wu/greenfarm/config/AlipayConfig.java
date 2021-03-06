package com.wu.greenfarm.config;

public class AlipayConfig {

    public static String app_id = "2021000117657547";
    //应用私钥
    public static String merchant_private_key= "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDJEQjL90VqVrz1Xq15JF9Pl51kWtr0yc+Lsn95GU+x1ppuh4RY05/ON8EYBhCcWGdGmQTHx0icx8J0woj277wey6l4+WwsdTsOlUqHnEUbcRBP54fZqqM2wajYzWdJTQay6WuWm05FPCrJrzer963fVnWdboQv9+Ad0Lk8mpGID3I+4SRUbUTipH01P2zobEu99EWobQO0XdJTqEPWrElzVGxwGt6+iCuoCYt2lfr2bGdtnRPQ2XQO66rJ9LtOiZzaTuCmhNHL/kbRWj3HvIHR5IjicDvhg4XEGbis4JFw174E6dI1bDmH4Lw2EeDRx0yz+kYsn6Yz7DgVEEOFlZt5AgMBAAECggEBAIHpJ63hjlAuytge3CaxgYODioYUzfPrkNXJ9uLfn8Zfylgv5ysdUNuE2pYTFRhvZgsPQy9xa1EhIFsgdi5Wp02eeVlYjrQK6qV5gDYumdgpLUjzZ6sTvXDbn6S00k9iHTnr5z/gCKpjPaIiO+44kXcD/epCRdZYac3Z1lV56R3m93cTsR1ldg0wtYDNHnfHam/YykNTONpLjurxt0WxBKG77YIonsZK15bKmw8xqLWS33xbPjvsjnyxPaT+PJrgT93RYsAwoPQD6eGllL+4KKptpJjHonEmUP8XEbAGUA/R5jstsrhn+1lrEM9UY27uMnCunlzQmOR6vkxWi/k77qECgYEA7ni6XYcNdPuSFIdjQti8sXxlsgEIZJ7SsRX4v//6K2xf/Pc5mx1Yrc0PMmWLs0GRzsn5FozNg0N1KZTSxP9N7nrqo1NASmgYXQCcvWs5UaNH07p/wgeh6gk3EPkLPBpMn5w0E5lt2yWhL0jMhf6vggdPDufiyu+pc6auTuWA8BMCgYEA19h2h9LMwmR96OM9bqmloDWjsynZyVKN7X+nFgDq1hczzJZ9uMcw9JVdxtiRm6yPysyXAvpeY8Ct0i65lEPvJmEgClaVoZ/wX4EJZaGlVQVqK9rqXMdN4uRJO/LzXjNF3uwk8z4lz/yLbEP1lTr5BdUlAbTz3Lw7+rQAA1Rv78MCgYA2W+jHhxCHOQ1MhqwWwccJgjzAPcIHBbkrSsHgKl6BZXvf8w77j832GEc9iq40l17AT4PrIv95y3e6mcUNyNCf6v7vafu+uknLcWdJOlbfiCPIXLvgo9LBwYX+5XYtJiWPQJESYqgLC2HZoHOWm76wGjBoSm2FKupqhXU4YNJqZwKBgQDBnU89qM65dPEojWYWtSB3pIXx+ZF9MItVRhN3/lyorGlvlHKz5CG6050p+Cwsy060qG6xYip3KmgBSJ55K7MC506ZV2+jaldxI8ttGeG3cUL6kcV2ceUgqIw0tUqu7ik3vPWsJ8w9VBkwhYluUlb8b2RhspKpJ0RaL0pvsjcyhwKBgHpKQvUekWEj37faG5VjFiFfy4qFtJJbTtyLELteDWqLNe2RnznKqSZLmRmRjF8I5vpxdWV5JZ2z0UGDiIseWeBsbvST/CIpp+Uh0Umnza5Undb6QyFHZDRfs0eIWm0C1olBDM9FXG2eB8k3Iw2pJ5IZYMMqZ8Hn335iDqmEW30p";
    //应用公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyREIy/dFala89V6teSRfT5edZFra9MnPi7J/eRlPsdaaboeEWNOfzjfBGAYQnFhnRpkEx8dInMfCdMKI9u+8HsupePlsLHU7DpVKh5xFG3EQT+eH2aqjNsGo2M1nSU0GsulrlptORTwqya83q/et31Z1nW6EL/fgHdC5PJqRiA9yPuEkVG1E4qR9NT9s6GxLvfRFqG0DtF3SU6hD1qxJc1RscBrevogrqAmLdpX69mxnbZ0T0Nl0DuuqyfS7Tomc2k7gpoTRy/5G0Vo9x7yB0eSI4nA74YOFxBm4rOCRcNe+BOnSNWw5h+C8NhHg0cdMs/pGLJ+mM+w4FRBDhZWbeQIDAQAB";
    //服务器异常通知页面
    public static String notify_url = "http://localhost:8081";

    public static String return_url = "http://localhost:8081/success";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
