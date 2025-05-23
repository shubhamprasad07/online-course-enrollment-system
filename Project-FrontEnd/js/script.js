let userDB = "http://localhost:8080/api/users";
let courseDB = "http://localhost:8080/api/courses";
let instructorDB = "http://localhost:8080/api/instructors";
let enrollmentDB = "http://localhost:8080/api/enrollments";
let dashboardDB = "http://localhost:8080/api/dashboard";

const user = localStorage.getItem("user");

document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll('a[data-page]').forEach(link => {
        link.addEventListener('click', function (e) {
            e.preventDefault();
            const page = this.getAttribute('data-page');
            sessionStorage.setItem('page', page);
            checkLoad(page);
        });
    });
});


function checkLoad() {
    if (sessionStorage.getItem('page')) {
        loadPage(sessionStorage.getItem('page'));
    }
    else {
        loadPage('pages/admin/adminDashboard.html');
    }
}

function loadPage(page) {
    fetch(`${page}`)
        .then(response => response.text())
        .then(data => {
            const container = document.getElementById('main-content');
            container.innerHTML = data;

            // Re-initialize MDB components
            if (typeof mdb !== 'undefined' && mdb.AutoInit) {
                mdb.AutoInit();
            }

            // Manually load and evaluate any scripts in the new content
            const scripts = container.querySelectorAll('script');
            scripts.forEach(script => {
                const newScript = document.createElement('script');
                if (script.src) {
                    newScript.src = script.src;
                } else {
                    newScript.textContent = script.textContent;
                }
                document.body.appendChild(newScript);
                script.remove();
            });
        })
        .catch(err => {
            document.getElementById('main-content').innerHTML =
                '<p class="text-danger">Failed to load content.</p>';
            console.error(err);
        });
}

function decodeJWT(token) {
    if (!token) return null;

    const parts = token.split('.');
    if (parts.length !== 3) return null; const payload = parts[1];
    // Base64URL decode
    const decodedPayload = atob(payload.replace(/-/g, '+').replace(/_/g, '/'));

    try {
        return JSON.parse(decodedPayload);
    } catch (e) {
        console.error("Invalid JWT payload:", e); return null;
    }
}

function getUserId() {
    const token = localStorage.getItem("token");
    if (!token)
        window.location.href = "login.html";
    const decoded = decodeJWT(token);
    return decoded.userid;
}

function getUserName() {
    const token = localStorage.getItem("token");
    if (!token)
        window.location.href = "login.html";
    const decoded = decodeJWT(token);
    return decoded.sub;
}

function getUserEmail() {
    const token = localStorage.getItem("token");
    if (!token)
        window.location.href = "login.html";;
    const decoded = decodeJWT(token);
    return decoded.email;
}

function getUserType() {
    const token = localStorage.getItem("token");
    if (!token)
        window.location.href = "login.html";
    const decoded = decodeJWT(token);
    return decoded.usertype;
}

function getAuthorization() {
    const token = localStorage.getItem("token");
    if (!token)
        window.location.href = "login.html";
    const decoded = decodeJWT(token);
    return `Bearer ${token}`;
}

function logout() {
    localStorage.removeItem("token");
    localStorage.clear();
    window.location.href = "/Project/login2.html";
}

// function logout() {
//     localStorage.removeItem("user");
//     window.location.href = "/Project/login.html"; // or wherever your login page is
// }