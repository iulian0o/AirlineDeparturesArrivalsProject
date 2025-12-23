const apiUrl = "http://localhost:8080/api";

function showMessage(text) {
    alert(text);
}

async function addPlane(e) {
    e.preventDefault();
    const data = {
        brand: document.getElementById('p-brand').value,
        model: document.getElementById('p-model').value,
        manufacturingYear: document.getElementById('p-year').value,
        capacity: document.getElementById('p-capacity').value
    };
    await fetch(`${apiUrl}/planes`, { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(data) });
    showMessage("Plane Added!");
}

async function addAirport(e) {
    e.preventDefault();
    const data = {
        nameAirport: document.getElementById('a-name').value,
        countryAirport: document.getElementById('a-country').value,
        cityAirport: document.getElementById('a-city').value,
        code: document.getElementById('a-code').value
    };
    await fetch(`${apiUrl}/airports`, { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(data) });
    showMessage("Airport Added!");
}

async function addFlight(e) {
    e.preventDefault();
    const data = {
        flightNumber: document.getElementById('f-number').value,
        departureTime: document.getElementById('f-dep-time').value,
        arrivalTime: document.getElementById('f-arr-time').value,
        ecoClassPrice: document.getElementById('f-eco-price').value,
        firstClassPrice: document.getElementById('f-first-price').value,
        plane: { idPlane: document.getElementById('f-plane-id').value },
        departureAirport: { idAirport: document.getElementById('f-dep-id').value },
        arrivalAirport: { idAirport: document.getElementById('f-arr-id').value }
    };
    const res = await fetch(`${apiUrl}/flights`, { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(data) });
    if(res.ok) showMessage("Flight Created!");
    else showMessage("Error creating flight. Check IDs.");
}