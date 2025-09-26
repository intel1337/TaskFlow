import type { Handle } from '@sveltejs/kit';

export const handle: Handle = async ({ event, resolve }) => {
	// Ajouter les en-têtes CORS pour toutes les réponses
	const response = await resolve(event);
	
	// Configuration CORS pour accepter toutes les origines
	response.headers.set('Access-Control-Allow-Origin', '*');
	response.headers.set('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, PATCH, OPTIONS');
	response.headers.set('Access-Control-Allow-Headers', 'Content-Type, Authorization, X-Requested-With');
	response.headers.set('Access-Control-Allow-Credentials', 'true');
	
	// Gérer les requêtes OPTIONS (preflight)
	if (event.request.method === 'OPTIONS') {
		return new Response(null, {
			status: 200,
			headers: {
				'Access-Control-Allow-Origin': '*',
				'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, PATCH, OPTIONS',
				'Access-Control-Allow-Headers': 'Content-Type, Authorization, X-Requested-With',
				'Access-Control-Allow-Credentials': 'true'
			}
		});
	}
	
	return response;
};
