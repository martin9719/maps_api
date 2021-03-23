var map;

function initMap() {
    // Makes the google map that is rendering and will center on coordinates and is a certain size
    map = new google.maps.Map(document.getElementById("map"), {
        center: coords,
        zoom: 10,
        scrollwheel: false,
    });

    // This is the marker and I assigned it an image and mde it a certain size
    var image = {
        url: "/pointing.png",
        scaledSize: new google.maps.Size(50, 50),
    };

    // Making a marker that will render on the map by using the coordinates it gets
    var marker = new google.maps.Marker({
        position: coords,
        map: map,
        icon: image,
        // animation: google.maps.Animation.BOUNCE,
    });

    // Setting the marker to bounce for a certain time
    marker.setAnimation(google.maps.Animation.BOUNCE);
    setTimeout(function() {
        marker.setAnimation(null);
    }, 2150);

    // String that holds the city and state the user gives
    var contentString = "<h2>" + city + ", " + state + "</h2>";

    // Will pop up with user clicks on the marker
    var infowindow = new google.maps.InfoWindow({
        content: contentString,
    });
    // Funciton that will happen when user clicks the marker (code line 62)
    google.maps.event.addListener(marker, "click", function() {
        infowindow.open(map, marker);
    });
}

// This is code that I have to look back on
// var map;
// // var coords = { lat: 39.9612, lng: -82.9988 };

// function initMap() {
//     map = new google.maps.Map(document.getElementById('map'), {
//         center: coords,
//         zoom: 10,
//         scrollwheel: false,
//     });
//     var image = {
//         url: '/pointing.png',
//         scaledSize: new google.maps.Size(50, 50),
//     };

//     var marker = new google.maps.Marker({
//         position: coords,
//         map: map,
//         icon: image,
//         animation: google.maps.Animation.BOUNCE,
//     });
//     var contentString = '<h2>' + city + '',
//         '' + state + '</h2>';

//     var infowindow = new google.maps.InfoWindow({
//         content: contentString,
//     });

//     google.maps.event.addListener(marker, 'click', function() {
//         infowindow.open(map, marker);
//     });
// }