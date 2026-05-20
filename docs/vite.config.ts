import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig(() => {
  return {
    base: "/contacty/",
    build: {
      outDir: "build",
    },
    plugins: [react()],
    server: {
        port: 5173
    }
  };
});
