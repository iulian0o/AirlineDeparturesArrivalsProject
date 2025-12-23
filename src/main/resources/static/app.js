let currentFlightNum = '';

async function searchFlights() {
    const from = document.getElementById('fromCity').value;
    const to = document.getElementById('toCity').value;
    const date = document.getElementById('flightDate').value;
    const tbody = document.querySelector('#flightsTable tbody');

    tbody.innerHTML = '<tr><td colspan="4">Searching...</td></tr>';
    document.getElementById('results-section').style.display = 'block';

    try {
        const response = await fetch(`http://localhost:8080/api/flights/search?from=${from}&to=${to}&date=${date}`);
        const flights = await response.json();

        tbody.innerHTML = '';
        if (flights.length === 0) {
            tbody.innerHTML = '<tr><td colspan="4">No flights found for this route/date.</td></tr>';
            return;
        }

        flights.forEach(f => {
            const row = `
                <tr>
                    <td>${f.flightNumber}</td>
                    <td>${f.departureTime.replace('T', ' ')}</td>
                    <td>$${f.ecoClassPrice}</td>
                    <td><button class="book-btn" onclick="openBooking('${f.flightNumber}')">Book</button></td>
                </tr>
            `;
            tbody.innerHTML += row;
        });
    } catch (error) {
        console.error(error);
        tbody.innerHTML = '<tr><td colspan="4" style="color:red">Error connecting to server</td></tr>';
    }
}

function openBooking(flightNum) {
    currentFlightNum = flightNum;
    document.getElementById('selectedFlight').innerText = flightNum;
    document.getElementById('bookingModal').style.display = 'block';
}

function closeModal() {
    document.getElementById('bookingModal').style.display = 'none';
}

async function confirmBooking() {
    const data = {
        firstname: document.getElementById('fname').value,
        lastname: document.getElementById('lname').value,
        passportNumber: document.getElementById('passport').value,
        birthdate: document.getElementById('birthdate').value,
        flightNumber: currentFlightNum,
        seatType: document.getElementById('seatType').value,
        departureCity: "",
        arrivalCity: ""
    };

    const msgDiv = document.getElementById('message');
    closeModal();

    try {
        const response = await fetch('http://localhost:8080/api/bookings', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        const text = await response.text();

        msgDiv.style.display = 'block';
        if (response.ok) {
            msgDiv.className = 'success';
            msgDiv.innerHTML = "Good " + text;
        } else {
            msgDiv.className = 'error';
            msgDiv.innerHTML = "Error: " + text;
        }
    } catch (error) {
        msgDiv.className = 'error';
        msgDiv.innerHTML = "Network Error";
    }
}