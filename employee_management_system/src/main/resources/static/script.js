const user1 = document.getElementById("user1");

function getUser() {
    // Display loading indicator while data is being fetched
    document.getElementById("loading").style.display = "block";

    // Fetch data from the server
    fetch(`http://localhost:8005/employees`)
        .then((res) => res.json())
        .then((data) => {
            // Process the data and build the HTML
            let userdata = "";
            data.forEach((element) => {
                userdata += `<tbody class=" border border-1 text-center ">
                                <tr>
                                <td>${element.id}</td>
                                <td>${element.name}</td> 
                                <td>${element.age}</td>
                                <td>${element.email}</td> 
                                <td><button>update</button></td>
                                 <td><button>delete</button></td>
                                </tr>
                              
                            </tbody>`;
            });

            // Update the HTML content after fetching and processing data
            user1.innerHTML = `
                <table class="container table-danger">
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