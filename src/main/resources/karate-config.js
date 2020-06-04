function config() {
    var env = karate.env;
    karate.log('Local api tests are running');

    karate.configure('logPrettyResponse', true);
    karate.configure('logPrettyRequest', true);

    return {
        env: env,
        baseUrl: "http://127.0.0.1:8080"
    };
}