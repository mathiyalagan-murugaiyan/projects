const user1 = document.getElementById("user1");

function getUser() {
    
    document.getElementById("loading").style.display = "block";


    fetch(`http://localhost:8005/employees`)
        .then((res) => res.json())
        .then((data) => {
           
            let userdata = "";
            data.forEach((element) => {
                userdata += `
               
                
                <tbody class=" border border-1 text-center ">
               
                                <tr>
                                <td>${element.id}</td>
                                <td>${element.name}</td> 
                                <td>${element.age}</td>
                                <td>${element.email}</td> 
                                <td><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                                update
                                 </button></td>
                                 <td><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">delete</button></td>
                                </tr>
                            
                            </tbody>`;
            });

            // Update the HTML content after fetching and processing data
            user1.innerHTML = `

            <button id="addemp" class="btn btn-info "> Add Employee</button>
                <table class="container table-danger text-center">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                    ${userdata}
                </table>`;


            // Hide the loading indicator after data is displayed
            document.getElementById("loading").style.display = "none";
        })
        .catch((error) => {
            console.error("Error fetching data:", error);
            // Optionally, update the UI to indicate an error
            user1.innerHTML = "Error fetching data. Please try again.";
            // Hide the loading indicator in case of an error
            document.getElementById("loading").style.display = "none";
        });
}