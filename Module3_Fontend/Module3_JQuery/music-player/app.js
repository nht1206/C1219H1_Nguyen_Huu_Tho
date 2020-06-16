const tracksTemplateSource = document.getElementById('tracks-template').innerHTML;
const tracksTemplate = Handlebars.compile(tracksTemplateSource);

const $tracks = $('#tracks-container');

const getTopTracks = $.get('https://api.napster.com/v2.1/tracks/top?apikey=ZWVjOTBhOTktYjVlZS00MjAxLWFiMjAtMDFiNDBmNDZhY2Ni');

getTopTracks
  .then((response) => {
    $tracks.html(tracksTemplate(response));
  });