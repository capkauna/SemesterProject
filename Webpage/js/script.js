
const createBookingBtn = document.getElementById('createBookingBtn');
    const cancelBookingBtn = document.getElementById('cancelBookingBtn');
    const createBookingForm = document.getElementById('createBookingForm');
    const cancelBookingForm = document.getElementById('cancelBookingForm');
    const notifications = document.getElementById('notifications');

    createBookingBtn.addEventListener('click', () => {
        createBookingForm.classList.toggle('hidden');
        cancelBookingForm.classList.add('hidden');
        notifications.innerHTML = '';
    });

    cancelBookingBtn.addEventListener('click', () => {
        cancelBookingForm.classList.toggle('hidden');
        createBookingForm.classList.add('hidden');
        notifications.innerHTML = '';
    });

    document.getElementById('checkAvailability').addEventListener('click', () => {
        const customerName = document.getElementById('customerName').value;
        const startDate = document.getElementById('startDate').value;
        const endDate = document.getElementById('endDate').value;

        if (!customerName || !startDate || !endDate) {
            notifications.textContent = 'Please fill in all fields.';
            return;
        }

        const start = new Date(startDate);
        const end = new Date(endDate);
        const nights = Math.ceil((end - start) / (1000 * 60 * 60 * 24));
        const cost = nights * 20;

        const isAvailable = Math.random() > 0.5;

        if (isAvailable) {
            notifications.textContent = `Booking confirmed for ${customerName}. Total cost: $${cost}. Notifications sent to both parties.`;
        } else {
            notifications.textContent = `No slots available. Please propose alternative dates.`;
        }
    });

    document.getElementById('confirmCancel').addEventListener('click', () => {
        const customerName = document.getElementById('cancelCustomerName').value;

        if (!customerName) {
            notifications.textContent = 'Please fill in all fields.';
            return;
        }

        notifications.textContent = `Booking for ${customerName} canceled. Notifications sent to both parties.`;
    });