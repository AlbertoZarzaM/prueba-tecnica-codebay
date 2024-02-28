<!DOCTYPE html>  
<html lang="en">  
<head>
    <meta charset="UTF-8">
    <title>Goldeneye</title>
    <style>
        .container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 2px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }
        
        h1 {
            font-size: 2.2em;
            line-height: 1.1;
            font-family: Inter, system-ui, Avenir, Helvetica, Arial, sans-serif;
            background-image: linear-gradient(to right, rgba(255, 255, 0, 0.2),#077968, #1B9EAA, #1B9EAA);
            -webkit-background-clip: text;
            color: transparent;
        }

        h2 {
            line-height: 1.1;
            font-family: Inter, system-ui, Avenir, Helvetica, Arial, sans-serif;
            background-image: linear-gradient(to right, #077968, #1B9EAA, #1B9EAA);
            -webkit-background-clip: text;
            color: transparent;
        }

        p {
            font-size: 18px;
            color: #333;
        }
        
        body {
            display: flex; 
            justify-content: center;
            align-items: center;
            background-color: #CCCCCA;

        }
        form {
            font-family: Inter, system-ui, Avenir, Helvetica, Arial, sans-serif;
            width: 400px;
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
            background-color: #077968;
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
        <script>
        function validateForm() {
            var name = document.getElementById('Name').value;
            var surname = document.getElementById('Surname').value;
            var office = document.getElementById('Office').value;
            var department = document.getElementById('Department').value;  
            var REGULAR_EXPRESSION = "^[A-Za-z]+(?:[ ][A-Za-z]+)*$"; 

            if (name.trim() === '' || !name.match(REGULAR_EXPRESSION)) {
                alert('Please enter a valid name.');
                return false;
            }
            if (surname.trim() === '' || !surname.match(REGULAR_EXPRESSION)) {
                alert('Please enter a valid surname.');
                return false;
            }
            if (office === '') {
                alert('Please select an office.');
                return false;
            }
            if (department === '') {
                alert('Please select a department.');
                return false;
            }
            return true;
        }

           function actualizarDepartamentos() {
            var officeSelect = document.getElementById("Office");
            var departmentSelect = document.getElementById("Department");
            var selectedOffice = officeSelect.value;

            // Limpiar select de departamentos
            departmentSelect.innerHTML = '';

            // Definir los departamentos permitidos para cada oficina
            var departments = {
                "Milan": [" ","Design", "Business", "Advertising"],
                "Spain": [" ","ResearchDevelopment", "Business"],
                "NewYork": [" ","Business", "Advertising"]
            };

            // Agregar las opciones de departamento permitidas para la oficina seleccionada
            departments[selectedOffice].forEach(function(department) {
                var option = document.createElement("option");
                option.text = department;
                option.value = department;
                departmentSelect.add(option);
            });
        }
    </script>
</head>
<body>
    
    <div>
     <h1 style="text-align: center;" >Goldeneye</h1> 
    <br>   
    <h2>Obtener email:</h2>
    <form action="/" method="post" onsubmit="return validateForm()">
        <label for="Name">Name:</label>
        <input type="text" id="Name" name="Name">
        <label for="Surname">Surname:</label>
        <input type="text" id="Surname" name="Surname">
        <label for="Office">Oficina:</label>
        <select id="Office" name="Office" onchange="actualizarDepartamentos()">
            <option value=""></option>
            <option value="Milan">Milan</option>
            <option value="NewYork">New York</option>
            <option value="Spain">Spain</option>
        </select>

        <label for="Department">Departamento:</label>
        <select id="Department" name="Department">
            <option value=""></option>
        </select>
        <br><br>
        <input type="submit" value="Submit">
    </form>
    <br>

    <#if email??>
        <div class="container">
          <p> The email is: ${email}</p>
        </div>
    <#else>  
    </#if>


        <#if error??> 
        <script>
            // Esto mostrará una alerta cuando la página se cargue
            window.alert("${error}");
        </script> 
        <#else>  </#if>
        
    </div>

    </body>
</html>