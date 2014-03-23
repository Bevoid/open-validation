open-validation
===============

This is a validation framework for java. This project is build by ``maven``. 

Contribute this project, please use command ``git clone ``. 

If you use eclipse as your primary java ide, you can run the command ``mvn eclipse:eclipse`` in the root folder to create eclipse project files, and import it.


quickstart
-------
You declare a bean like this.
```java
public class TestBean {

    @NotNull
    public String        username = "example";

    @NotNull
    public String        password = null;

    @Max(100)
    public Integer       age      = 80;

    @Max(100)
    public Double        count    = 101.;

    @Max(199.9)
    private final Double address  = 200.;

    /**
     * Getter method for property <tt>address</tt>.
     * 
     * @return property value of address
     */
    public Double getAddress() {
        return address;
    }

}
```

And valiate the bean with the class ``Valiation`` like this.
```java
validation.validateBean(testBean);
for (ValidateError ve : validation.getValidateError()) {
    System.out.println(ve);
}
```

You will get an output like this:
```
Unpassed: @NotNull field: password value: null
Unpassed: @Max field: count value: 101.0
Unpassed: @Max field: address value: 200.0
```

You can handle ``validation.getValidateError()`` with your own wrong handle method.

feature
-------
1. Use annotation.
2. Or direct api.
3. Other feature adding.
4. I am a web devloper, so i know the most direct demand on valiation. (Welcome to share me the valiation problme in your devloping, i will try to make it easier in this framework.)

todo
-------
1. Make annotation directly on getter method availably.
2. Complete more valiation annoation and handler.
3. Make combinaion of annoation possible.
4. Complete direct check api.
5. Make the method parameter check availably.
6. Think about the mult-thread and static issue in the framwork.

author
-------
Contact me through ```wksoraATgmail.com```
