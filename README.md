<em> <h1 align="center"> Control de Estudiantes </h1> </em>

<p align="center">
<img alt="GitHub last commit (by committer)" src="https://img.shields.io/github/last-commit/NoxSlow99/control-student-graphql?style=plastic&color=001933">

<img alt="GitHub contributors" src="https://img.shields.io/github/contributors/NoxSlow99/control-student-graphql?style=plastic&color=001933">

<img alt="GitHub repo size" src="https://img.shields.io/github/repo-size/NoxSlow99/control-student-graphql?style=social">

<img alt="GitHub Repo stars" src="https://img.shields.io/github/stars/NoxSlow99/control-student-graphql?style=social">

<img alt="GitHub watchers" src="https://img.shields.io/github/watchers/NoxSlow99/control-student-graphql?style=social">

<img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/org.springframework.boot/spring-boot-starter-data-jpa?style=plastic&logo=spring%20boot&label=Spring Boot&labelColor=ffffff&color=%236DB33F">

<img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/org.springframework.boot/spring-boot-starter-graphql?style=plastic&logo=graphql&label=GraphQL&labelColor=%23E10098">

<img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/com.auth0/java-jwt?style=plastic&logo=json%20web%20tokens&label=JWT&labelColor=%23000000">

<img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/com.mysql/mysql-connector-j?style=plastic&logo=mysql&label=MySQL&labelColor=ffffff&color=%234479A1">

</p>

<h2 name="indice"> Índice </h2>

- [Índice](#indice)

- [Descripción](#descripcion)

- [Caracteristicas](#caracteristicas)

- [Objetivo](#objetivo)

- [Tecnologías usadas](#tecnologias-usadas)

- [Autores](#autores)

<h4 name="descripcion"> Descripción </h4>
<p> Este proyecto es una aplicación web desarrollada en Java utilizando el framework Spring Boot. En lugar de utilizar la arquitectura RESTful, 
  este proyecto se basa en GraphQL para la gestión de datos. </p>

<h2 name="Caracteristicas"> :hammer:Caracteristicas </h2>

- `GraphQL`: Este proyecto utiliza GraphQL, una alternativa a RESTful, para la gestión de datos. GraphQL permite a los clientes definir la estructura de los datos requeridos,
   lo que permite una mayor eficiencia en la transferencia de datos.

- `Entidades`: El proyecto está compuesto por varias entidades, incluyendo estudiantes, campus, divisiones y carreras. Cada una de estas entidades tiene su propio conjunto
  de atributos y relaciones con las otras entidades.

- :closed_lock_with_key: `Seguridad`: Este proyecto implementa un filtro de seguridad basado en JWT (JSON Web Tokens). Los JWT son una forma segura de transmitir información entre partes como un
  objeto JSON. Este mecanismo de seguridad garantiza que solo los usuarios autorizados puedan acceder a ciertos recursos.

<h2 name="objetivo"> Objetivo </h2>
El objetivo de este proyecto es proporcionar una aplicación web segura y eficiente para la gestión de estudiantes, campus, divisiones y carreras utilizando las últimas 
tecnologías y mejores prácticas.

<h2 name="tecnologias-usadas"> :ballot_box_with_check: Tecnologías usadas </h2>

- ![Java](https://img.shields.io/badge/Java-f89820?style=plastic&logo=data%3Aimage%2Fpng%3Bbase64%2CiVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAACXBIWXMAAAsTAAALEwEAmpwYAAAFlElEQVR4nO1Xa2xURRQeQERUrG1ntoD4woIS8bmdu%2BUR6967xQooYCxBpSq7Zy4v8REV%2F0iqxkR8JMZfYkKMiUZC%2FeEzJEi6Z5YCf6j4iATUKA9jCA%2Bx3XtLA0HWnNlH19Jaomy7Nf2SyXbPvZ39zsx3vjPD2BCGMIR%2BQadTNZENZniOfGhQJ%2BE51tpkRC5ngxFts6rLfFse9hz5AhtsSDWy4Z5jbfIdK9VhW0vZYEKqvn6E58j1RN6z5ekTkeBVbLAgVVNzke9YTUTeJODId9mg0rxjJfLI70%2FWBDk9S9VVjvLDodm%2Bbb3l29ZGzw7dzIoJ7Y6c7Dvypxx52%2Brww9YtR6dPH%2BM78nnfsY6mn8kNbTNnlrJiQkc4FPRt%2BXse%2BZO%2BI%2Bu82qqpvmPtzdaCZ1srWbGhsyZ0jedYh7rIy9MdtlxA8eyq0250ONY8VozwHLk5S55G0qlaQXGSSi6piFzIihFe7bSA51hn8op2HcVTweBIz5GdGc3vZsWK9khoUn7RZouzw66%2BIm9X9rLi7rby10wCO3PxuspRxoWysrozOIMVK3xHrjFEbastVV09Oi%2F%2BZtcuyGZW1J3XtvYYohGpuh%2FkchILyxtZsSI5K3iD78jjpHeSVTbuReSDuV0IW8%2BwYsYJR05LNzM5NxujZHzbOpJJIsqKHclIaIrvyC%2FJRrMx37aOkZSOR4IlA8uOMcYhHhRKr%2BaA7wnATVzh2kBM11au2jQq%2B05HjTXBd6puM3%2BHQ%2Fd6jtxHR43uc5UrLQXoJqHwBwEY527ijoIRL3kELxeACaF0Kj3wTF8%2FaIo7bDUcq7MuM4Sj28YLF2cKhQ1lgBMqFm%2B%2BxMQUrqc5OeCJUrelMPeGAGB1F%2FlcEkmu8FsOegsN2hFaUa70J%2Ba70q0C9B6h8CBXujP7P8LV9d1SHSaU3pt5%2FlhBEjBJKIwIwE856KNnJ9PbwCQH%2FE4o3MhBN5ZHm6%2FvaW7RtburWX%2BAtp5HcZGIYoMAvJ9WVcT0fZRkWSxhlcX0FLECLz2XuUqWt5RypX0jIzc%2Bp%2BDkJzy1YzTJJLPCDSSBf3p%2F%2FMot5QEX5%2Fembw76dTMX6D2sES8oGPHcD7rxOX%2BTCeABAfoLofAdrvTbNITCDzK1sU8A%2FpkuUu1xVz%2FOGlO5RscB5wqlT3PAw4HY1n66YjamhnNARQVMbnSOtXBQAK4TbmIWc1tNjwhAfF5aOriRXIkNBDhsmRyI4eIA4DIB%2BjkO%2BhUaAvBZDolYwI0741w0l%2Fp8iBhWCsBVY6PNV7OBAlc6SivIQX8sVuDYriepYUQ64OqbBOiHhdIfUuO7LLajbMDIsvqmERVRnMrdxO0Vy7YHKCQAj%2BfLxMjBxHqWFQd9iByqX3mXLG8pNZ0ySzb9%2BTkdH7jCRaZI%2B9A%2FFagAvUFA%2FK6eHGvskq2CK%2F1aX272r8CV%2FrrLbbSm9n%2FWO0v1pADoBdk6IG0b%2Fcd0rXCbr%2BuLGAe9kOavcOOh856AcY8uCewjCZ2vuSuWbQ8I0C8JwFO0SwWpEVoVrvBIN9%2F%2FSgC%2BwQEfELH4DNOgMtbYI%2Bq%2Fv5C7iXHk86Zrp0knhMKTGYvdRfWVn9h5TaI8um1MxiK%2F6VXr1KyoPtLjAFf4Mw0B2N7L%2B%2B3k%2F%2BUxfU9%2BYyPbpS7PCgVqOKR3AfgiV%2Fp9rvQ2qhNDGPShPGf6gyv8hVZXKGw2p1TAV8l6TcetbxqRP68AvJUr%2FZEA3Ub3hIIlQKtV%2BmjiSpLFf52qAhLXcsAnyRzS1ou7%2Buc44baO5ErfzZV%2Bgm5kdEzmLgKdkcpdrDKutKRlIg3quKaOYno2HfwE4MsC8DOu9P6MlE4ZW3Zxfr6U%2BhGpYYasi%2FO5i2vMFRH0TgH4o1D4G0kp7TJGXrs56BajfVc%2FTbezcW7rxQNAeghD%2BF%2FgL76ssK8TFCCXAAAAAElFTkSuQmCC&logoColor=ffffff)
- ![SPring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=plastic&logo=spring%20boot&logoColor=ffffff)
- ![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=plastic&logo=spring%20security&logoColor=ffffff)
- ![GraphQL](https://img.shields.io/badge/GraphQL-E10098?style=plastic&logo=graphql)
- ![JSON Web Tokens](https://img.shields.io/badge/JSON%20Web%20Tokens-000000?style=plastic&logo=json%20web%20tokens)
- ![MySQL](https://img.shields.io/badge/MySQL-353936?style=plastic&logo=mysql)


<h4> Autores </h4>

<a href="https://github.com/NoxSlow99" target="_blank" name="autores"> Angel Colli </a>
