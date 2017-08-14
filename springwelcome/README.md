# Neat sample for spring IOC

### Step1: 
```
  Create java project
```



### Step2: 
```
  Convert java project into Marven project
```



### Step3: 
```
 Add following dependency in pom.xml
 
 <!-- Spring framework -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring</artifactId>
			<version>2.5.6</version>
		</dependency>
```

### Step4: the meta data info shoul be DOCTYPE bean ... instead of "<xml ...?>..."
```
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
					"http://www.springframework.org/dtd/spring-beans-2.0.dtd">

<beans>
	<bean id="id1" class="springwelcome.WelcomeBean">
		<property name="message" value="Welcom to spring"></property>
	</bean>
</beans>

```

