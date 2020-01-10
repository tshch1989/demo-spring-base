# BeanPostProcessor更多实例功能说明
* AutowiredAnnotationBeanPostProcessor 对@Autowired，@Value支持注入
* CommonAnnotationBeanPostProcessor 通用注解支持
* CommonAnnotationBeanPostProcessor 对Required支持
##### ApplicationContextAwareProcessor 对多个aware接口注入
* EnvironmentAware 
* EmbeddedValueResolverAware 
* ResourceLoaderAware 
* ApplicationEventPublisherAware 
* MessageSourceAwareApplicationContextAware