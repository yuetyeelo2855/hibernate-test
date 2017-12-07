# Important Note

## About `@Transactional`
Make sure `@Transactional` only using in service level, don't using it outside class. 
Even need to using the property of lazy load, using below method: 
* using `Hibernate.initialize(Object proxy)` to load all property of entity in `@Transactional`
* using Spring `OpenSessionInViewFilter` to delay the session close time
* if need to using with Jackson, using [jackson-datatype-hibernate](https://github.com/FasterXML/jackson-datatype-hibernate) 