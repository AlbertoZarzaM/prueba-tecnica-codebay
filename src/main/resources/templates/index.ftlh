<!DOCTYPE html>  
<html lang="en">  
<head>
    <meta charset="UTF-8">
    <title>Goldeneye</title>
    <style>
        body {
            display: flex; 
            justify-content: center;
            align-items: center;
        }
        form {
            width: 300px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        label, input {
            display: block;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    
    <div style="max-width: 200px;">
     <h1>Goldeneye</h1> 
    <br>   
    <h2>Obtener email:</h2>
    <form action="/" method="post">
        <label for="Name">Nombre:</label>
        <input type="text" id="Name" name="Name">
        <label for="Surname">Apellido:</label>
        <input type="text" id="Surname" name="Surname">
        <label for="Office">Oficina:</label>
        <select id="Office" name="Office">
            <option value=""></option>
            <option value="Milan">Milan</option>
            <option value="NewYork">Nueva York</option>
            <option value="Spain">Spain</option>
        </select>
        
        <label for="Department">Departamento:</label>
        <select id="Department" name="Department">
            <option value=""></option>
            <option value="Design">Design</option>
            <option value="Business">Business</option>
            <option value="ResearchDevelopment">Research & Development</option>
            <option value="Advertising">Advertising</option>
        </select>
        <br><br>
        <input type="submit" value="Enviar">
    </form>
    </div>
    <br>

    <#if email??>
        "${email}"
    <#else>  
    </#if>


        <#if error??> 
        <script>
            // Esto mostrará una alerta cuando la página se cargue
            window.alert("${error}");
        </script> 
        <#else>  </#if>
        

    </body>
</html>