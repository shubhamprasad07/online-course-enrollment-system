let courseDB = "http://localhost:3000/Courses";
let instructorDB = "http://localhost:3000/Instructors";

let courses = []

let courseTableBody = document.getElementById("courseTableBody");

let courseId = document.getElementById("courseId");
let courseTitle = document.getElementById("courseTitle");
let courseDesc = document.getElementById("courseDesc");
let instructorId = document.getElementById("instructorId");

let form = document.getElementById("form");

form.addEventListener("submit", function(e){
    e.preventDefault();
    if (!(courseId && courseTitle && courseDesc && instructorId)) return 
    console.log(courseId.value)
    console.log(courseTitle.value)
    console.log(courseDesc.value)
    console.log(instructorId.value) 

    const course = {
        "CourseID" : courseId.value,
        "Title": courseTitle.value,
        "Description": courseDesc.value,
        "InstructorID": instructorId.value,
    }

    fetch(courseDB, {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(course)
    }).then( () => {
        fetchAndRender();
    })
})

function fetchAndRender() {
    fetch(courseDB)
        .then(res => res.json())
        .then(data => {
            courses = data;
            renderTable(data);
        })
}

function loadOptions(data){
    fetch(instructorDB)
        .then(res => res.json())
        .then(data => {
            courses = data;
            data.forEach( d => {
                instructorId.innerHTML += `<option value = "${d.InstructorID}">${d.Name}</option>`;
            } )
        })
}

function renderTable(data) {
    courseTableBody.innerHTML = "";
    data.forEach(d => {
        courseTableBody.innerHTML +=
            `<tr>
                <td>${d.CourseID}</td>
                <td>${d.Title}</td>
                <td>${d.Description}</td>
                <td>${d.InstructorID}</td>
                <td>
                    <button class="delete-btn">Delete</button>
                    <button class="edit-btn edit-id = ${d.CourseID}">Edit</button>
                </td>
            </tr>`

        document.querySelector(".delete-btn").forEach( d => {
            d.addEventListener("click", function(e){
                e.preventDefault();
            })
        } )

        document.querySelector(".delete-btn").forEach( d => {

        } )

    })
}

