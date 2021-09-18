### FMU4j

FMU4j is a software package for the JVM that enables
export of FMI 2.0 for Co-simulation.


###### Write the code

```java
@SlaveInfo(
        modelName = "MyJavaSlave",
        author = "John Doe"
)
public class JavaSlave extends Fmi2Slave {
    
    @ScalarVariable
    private int intOut = 99;
    @ScalarVariable
    private double realOut = 2.0;
    @ScalarVariable
    private double[] realsOut = {50.0, 200.0};
    @ScalarVariable
    private String[] string = {"Hello", "world!"};
    
    private ComplexObject obj = ComplexObject();
    
    public JavaSlave(Map<String, Object> args) {
        super(args);
    }

    @Override
    protected void registerVariables() {
        register(integer("complexInt", () -> obj.integer)
                .causality(Fmi2Causality.output));
        register(real("complexReal", () -> obj.real)
                .causality(Fmi2Causality.output));
    }

    @Override
    public void doStep(double currentTime, double dt) {
        realOut += dt;
    }

}
```
###### Build the FMU

```
Usage: fmu-builder [-h] [-d=<destFile>] -f=<jarFile> -m=<mainClass>
  -d, --dest=<destFile>    Where to save the FMU.
  -f, --file=<jarFile>     Path to the Jar.
  -h, --help               Print this message and quits.
  -m, --main=<mainClass>   Fully qualified name of the main class.
```

In order to build the `fmu-builder` tool, clone this repository and invoke `./gradlew installDist`.
The distribution will be located in the folder _fmu-builder-app/build/install_.

*** 

Would you rather build FMUs using Python? Check out [PythonFMU](https://github.com/NTNU-IHB/PythonFMU)! <br>
Or would you rather simulate FMUs using C++? Check out [FMI4cpp](https://github.com/NTNU-IHB/FMI4cpp)! <br>
Need to distribute your FMUs? [FMU-proxy](https://github.com/NTNU-IHB/FMU-proxy) to the rescue! <br>
Need a complete co-simulation framework with SSP support? Check out [Vico](https://github.com/NTNU-IHB/Vico) <br>
