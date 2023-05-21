
function deleteCommunity(communityId) {
    // Send DELETE request to the server
    fetch(`/admin/${communityId}/community`, {
        method: 'DELETE'
    })
        .then(response => response.json())
        .then(data => {
            // Handle response from the server
            console.log(data);
            // Perform any action after successful deletion, such as updating the UI or reloading the page
        })
        .catch(error => {
            // Handle error
            console.error('Error:', error);
        });
}

// Attach event listener to the "Delete" button
document.getElementById('deleteCommunityButton').addEventListener('click', function(event) {
    event.preventDefault(); // Prevent the default link behavior
    var communityId = 123; // Replace with the actual community ID
    deleteCommunity(communityId);
    changePage('admin');
});

// Function to delete an artist
function deleteArtist(communityId, artistId) {
    // Send DELETE request to the server
    fetch(`/admin/${communityId}/community/${artistId}`, {
        method: 'DELETE'
    })
        .then(response => response.json())
        .then(data => {
            // Handle response from the server
            console.log(data);
            // Perform any action after successful deletion, such as updating the UI or reloading the page
        })
        .catch(error => {
            // Handle error
            console.error('Error:', error);
        });
}


function changePage(url) {
    window.location.href = url;
}