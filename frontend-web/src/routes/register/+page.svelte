<script>
    import { onMount } from 'svelte'

    let responseData = $state(null)
    let errorMessage = $state(null)
    let isLoading = $state(false)

    async function handleSubmit(event) {
        event.preventDefault()
        isLoading = true
        errorMessage = null
        responseData = null
        
        try {
            const formData = new FormData(event.target)
            const data = Object.fromEntries(formData)
            
            console.log('Sending data:', data) // Debug

            const response = await fetch('http://localhost:8080/api/users/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(data)
            })

            console.log('Response status:', response.status) // Debug
            
            if (!response.ok) {
                const errorText = await response.text()
                console.log('Error response:', errorText) // Debug
                throw new Error(`HTTP ${response.status}: ${errorText}`)
            }

            const result = await response.json()
            responseData = result
            console.log('Success:', result) // Debug
            
        } catch (error) {
            console.error('Registration error:', error)
            errorMessage = error.message
        } finally {
            isLoading = false
        }
    }
</script>


<form onsubmit={handleSubmit}>
    <input type="text" name="name" placeholder="Name" required />
    <input type="password" name="password" placeholder="Password" required />
    <input type="email" name="email" placeholder="Email" required />
    <button type="submit" disabled={isLoading}>
        {isLoading ? 'En cours...' : 'S\'inscrire'}
    </button>
    
    {#if errorMessage}
        <div class="error">
            ❌ Erreur: {errorMessage}
        </div>
    {/if}
    
    {#if responseData}
        <div class="success">
            ✅ Inscription réussie! 
            <br>ID: {responseData.id}
            <br>Nom: {responseData.name}
            <br>Email: {responseData.email}
        </div>
    {/if}
</form>

<style>
    form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        display: flex;
        flex-direction: column;
        gap: 10px;
    }
    
    input {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    
    button {
        padding: 10px;
        background: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    
    button:disabled {
        background: #ccc;
        cursor: not-allowed;
    }
    
    .error {
        color: red;
        background: #fee;
        padding: 10px;
        border-radius: 4px;
        border: 1px solid red;
    }
    
    .success {
        color: green;
        background: #efe;
        padding: 10px;
        border-radius: 4px;
        border: 1px solid green;
    }
</style>