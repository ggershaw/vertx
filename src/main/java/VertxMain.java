import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.impl.launcher.VertxLifecycleHooks;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.dropwizard.DropwizardMetricsOptions;
import io.vertx.ext.dropwizard.Match;
import io.vertx.ext.dropwizard.MatchType;

public class VertxMain implements VertxLifecycleHooks{

    public static void main(String[] args) {
        Vertx vertx  = Vertx.vertx(new VertxOptions().setMetricsOptions(new DropwizardMetricsOptions().setEnabled(true)
                .setRegistryName("registry")));
        vertx.deployVerticle(SenderVerticle.class, new DeploymentOptions().setInstances(5));
        vertx.deployVerticle(new ReceiverVerticle());
        vertx.deployVerticle(new PerformanceVerticle());
    }

    @Override
    public void afterConfigParsed(JsonObject jsonObject) {

    }

    @Override
    public void beforeStartingVertx(VertxOptions vertxOptions) {


    }

    @Override
    public void afterStartingVertx(Vertx vertx) {

    }

    @Override
    public void beforeDeployingVerticle(DeploymentOptions deploymentOptions) {

    }

    @Override
    public void beforeStoppingVertx(Vertx vertx) {

    }

    @Override
    public void afterStoppingVertx() {

    }

    @Override
    public void handleDeployFailed(Vertx vertx, String s, DeploymentOptions deploymentOptions, Throwable throwable) {

    }
}
