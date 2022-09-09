
// helper method for displaying a status message.
const setMessage = (message) => {
  const messageDiv = document.querySelector('#messages');
  messageDiv.innerHTML += "<br>" + message;
}

// Fetch public key and initialize Stripe.
let stripe, cardElement;

fetch('/rest/config')
  .then((resp) => resp.json())
  .then((resp) => {
    console.log(resp)
    stripe = Stripe(resp.publishableKey);

    const elements = stripe.elements();

    const cardElement = elements.create('card');
    cardElement.mount('#card-element');
  });
  // Extract the client secret query string argument. This is
  // required to confirm the payment intent from the front-end.
  const subscriptionId = window.sessionStorage.getItem('subscriptionId');
  const clientSecret = window.sessionStorage.getItem('clientSecret');

  //FORMS STUFF
  const form = document.querySelector('#subscribe-form');
  form.addEventListener('submit', async (e) => {
  console.log("SUBMITTING")
    e.preventDefault();
    const nameInput = document.getElementById('name');

    // Create payment method and confirm payment intent.
    stripe.confirmCardPayment(clientSecret, {
      payment_method: {
        card: cardElement,
        billing_details: {
          name: nameInput.value,
        },
      }
    }).then((result) => {
      if(result.error) {
        setMessage(`Payment failed: ${result.error.message}`);
      } else {
        // Redirect the customer to their account page
        setMessage('Success! Redirecting to your account.');
        window.location.href = '/account.html';
      }
    });
  });