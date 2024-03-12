import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  server: {
    //port: 3000, // Or any port you prefer
    proxy: {
      '/api': {
        target: 'http://127.0.0.1:8080', // Assuming your Spring Boot backend runs on port 8080
        changeOrigin: true,
        //rewrite: (path) => path.replace(/^\/api/, '') // Remove /api prefix
      }
    }
  },
  plugins: [react()],
})
