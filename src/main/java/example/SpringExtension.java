package example;

import akka.actor.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;

@Component
public class SpringExtension implements Extension {
  private ApplicationContext applicationContext;

  void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  Props props(String actorBeanName) {
    return Props.create(SpringActorProducer.class, applicationContext, actorBeanName);
  }
}
