
function finishTrack(start, target ){ return( arrivalStatus() ? (((Date.now() - start) < target ? win() : lose())) : "Not there yet!")}
function startTrack(){ return Date.now()}
function win(){ return "Yay! You did it!"}
function lose(){ return "Try again some other time!"}
function arrivalStatus(){
    //abandoned haversine formula, this method is way more accurate
    return(google.maps.geometry.spherical.computeDistanceBetween (new google.maps.LatLng(getUserX(),getUserY()),new google.maps.LatLng(challengeTo["lat"],challengeTo["lng"]))<1 ? true : false);

}