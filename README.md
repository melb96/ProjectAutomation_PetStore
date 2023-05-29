<h1 align="center">PROJECT PATH AUTOMATION</h1>

<h2 align="center">Luna Bazán, Mateo</h2>

<h3> Descripción breve </h3>

<p align="center"> Este es un test project desarrollado en Java utilizando las librerias de Selenium, TestNG, JUnit y Apache POI. Su finalidad es automatizar los posibles casos de prueba de la pagina seleccionada, en este caso "Pet Store".</p>

<h3> Instrucciones </h3>

1.Crear proyecto maven en tu IDE favorito.

2.Agregar dependencias en archivo pom.xml

Selenium:

```shell
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
```
TestNG

```shell
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.9.8</version>
            <scope>test</scope>
        </dependency>
```

JUnit

```shell
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.1</version>
        </dependency>
```

Apache POI

```shell
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>4.1.2</version>
        </dependency>
```

```shell
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>4.1.2</version>
        </dependency>
```

3. Utilizar estructura POM (Page Object Model) para organizar las pages, tests y utilities.

```shell
  test
      java
        tests
        pages
        utilities  
```

4. En el directorio utilities dar de alta una clase Base para declarar todas las funciones que se van a utilizar en el proyecto.

```shell
  test
      java
        tests
        pages
        utilities
          Base
```
5. Crear un directorio resources para agregar el WebDriver a utilizar, en este caso usaremos chromedriver.

```shell
https://chromedriver.chromium.org/
```

```shell
  test
      java
        tests
        pages
        utilities  
      resources
        driver
          chromedriver.exe
```
6. Crear un directorio data en el directorio resources para cargar un excel que usaremos para obtener los datos a traves de la libreria Apache POI.

```shell
  test
      java
        tests
        pages
        utilities  
      resources
        data
          database.xlsx
        driver 
```
7. Definir la parametrizacion del proyecto via properties file. Creando un archivo file y agregandolo en el directorio resources. Luego llamando estas propiedades con una funcion declarada en la clase Base.

```shell
  test
      java
        tests
        pages
        utilities  
      resources
        data
        driver
        Setup.properties
```
Funcion para llamar las propiedades:

```shell
    public Base(WebDriver driver) {
        this.driver = driver;
        loadProperties();
    }

    private void loadProperties(){

        prop = new Properties();

        try {
            InputStream input = new FileInputStream(ruteProject + "\\src\\test\\resources\\Setup.properties");
            {
                prop.load(input);
            }
        }catch (IOException e){
            System.out.println("No fue posible llamar archivo properties.");
            e.printStackTrace();
        }
    }
```
8. Generar reportes via TestNG (Plugin Maven surefireReports).

Configuramos en el archivo pom.xml los plugins necesarios:

```shell
 <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-clean-plugin</artifactId>
                <version>3.1.0</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>

                <artifactId>maven-resources-plugin</artifactId>
                <version>3.0.2</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

Creamos el archivo testng.xml

```shell
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite de Pruebas">

    <test name="Pruebas de Login">
        <classes>
            <class name="tests.SignInTest"/>
        </classes>
    </test>

    <test name="Pruebas de Registro">
    <classes>
              <class name="tests.SignUpTest" />
    </classes>
    </test>

    <test name="Pruebas de Busqueda">
        <classes>
            <class name="tests.SearchTest" />
        </classes>
    </test>

    <test name="Pruebas de Cart">
        <classes>
            <class name="tests.CartTest" />
        </classes>
    </test>

    <test name="Pruebas de Modificar cuenta">
        <classes>
            <class name="tests.EditAccountTest" />
        </classes>
    </test>

    <test name="Pruebas de Cerrar sesion">
        <classes>
            <class name="tests.SignOutTest" />
        </classes>
    </test>

</suite>
```

9. Ejecutar los tests via comando mvn test.
