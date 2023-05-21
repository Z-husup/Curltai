
// Function to handle the ban user action
function banUser(userId) {
    // Make an AJAX request to the server to ban the user
    fetch('/admin/ban', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ userId: userId })
    })
        .then(response => {
            if (response.ok) {
                // User banned successfully
                console.log('User banned successfully');
            } else {
                // Error occurred while banning user
                console.error('Failed to ban user');
            }
        })
        .catch(error => {
            console.error('An error occurred:', error);
        });
}
