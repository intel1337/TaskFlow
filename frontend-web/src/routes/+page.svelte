<script lang="ts">
    import { goto } from '$app/navigation'
</script>

<h1>Hello World</h1>
<button on:click={() => goto('/register')}>Register</button>