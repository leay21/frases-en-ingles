const API_URL = 'http://localhost:8081/api/phrases';
const formPhrases = document.getElementById('form-phrases');
const phrasesList = document.getElementById('translated-phrases');	

formPhrases.addEventListener('submit', async (event) => {
    event.preventDefault();
    const formData = new FormData(formPhrases);
    const phrase = formData.get('phrase');
    console.log('Phrase to send:', phrase);
    
    if (!phrase) {
        alert('Please enter a phrase to translate.');
        return;
    }

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ originalText: phrase })
        });
        console.log('Response status:', response.status);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();
        displayTranslatedPhrase(data.translatedText);
    } catch (error) {
        console.error('Error:', error);
        alert('Failed to translate the phrase. Please try again later.');
    }

    
});

// Función para mostrar la frase traducida
function displayTranslatedPhrase(translatedPhrase) {
    const listItem = document.createElement('li');
    listItem.textContent = translatedPhrase;
    phrasesList.appendChild(listItem);
}