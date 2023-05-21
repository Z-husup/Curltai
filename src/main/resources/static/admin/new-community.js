function createCommunity() {
    // Get form data
    var communityName = document.getElementById('communityName').value;
    var communityImage = document.getElementById('communityImage').files[0];
    var communityDescription = document.getElementById('communityDescription').value;

    // Create request payload
    var payload = {
        name: communityName,
        image: communityImage,
        description: communityDescription
    };

    // Send POST request to the server
    fetch('/admin/new-community', {
        method: 'POST',
        body: JSON.stringify(payload),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            // Redirect to the newly created community page
            const communityId = data.id; // Assuming the response contains the ID of the newly created community
            window.location.href = `/admin/${communityId}/community`; // Replace with the appropriate URL for the community page
        })
        .catch(error => {
            // Handle error
            console.error('Error:', error);
        });
}
