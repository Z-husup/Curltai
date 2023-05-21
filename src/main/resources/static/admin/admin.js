// Function to create a community element
function createCommunityElement(community) {
    var col = document.createElement('div');
    col.classList.add('col', 'col-md-4');

    var communityDiv = document.createElement('div');
    communityDiv.classList.add('community');

    var image = document.createElement('img');
    image.classList.add('rounded', 'img-fluid', 'd-block', 'w-100', 'fit-cover');
    image.style.height = '200px';
    image.src = community.image;

    var contentDiv = document.createElement('div');
    contentDiv.classList.add('py-4');

    var title = document.createElement('h4');
    title.textContent = community.name;

    var description = document.createElement('p');
    description.textContent = community.description;

    contentDiv.appendChild(title);
    contentDiv.appendChild(description);

    communityDiv.appendChild(image);
    communityDiv.appendChild(contentDiv);

    col.appendChild(communityDiv);

    return col;
}

// Get the container element where the communities will be displayed
var communityContainer = document.getElementById('communityContainer');

// Fetch the communities data from the REST API
fetch('/admin')
    .then(response => response.json())
    .then(data => {
        // Generate HTML elements for each community
        data.forEach(community => {
            var communityElement = createCommunityElement(community);
            communityContainer.appendChild(communityElement);
        });
    })
    .catch(error => {
        console.error('Error:', error);
    });
