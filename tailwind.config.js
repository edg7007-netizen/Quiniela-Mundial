/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/main/resources/templates/**/*.html'
  ],
  theme: {
    extend: {
      fontFamily: {
        display: ['Inter', 'system-ui', 'sans-serif']
      }
    }
  },
  plugins: [require('daisyui')],
  daisyui: {
    themes: [
      {
        fifa2026: {
          primary: '#5b21b6',
          'primary-content': '#f5f3ff',
          secondary: '#0f766e',
          'secondary-content': '#ecfeff',
          accent: '#d4a017',
          'accent-content': '#1f1300',
          neutral: '#1e1b4b',
          'neutral-content': '#ede9fe',
          'base-100': '#ffffff',
          'base-200': '#f8fafc',
          'base-300': '#e2e8f0',
          'base-content': '#111827',
          info: '#0ea5e9',
          success: '#16a34a',
          warning: '#f59e0b',
          error: '#dc2626'
        }
      }
    ]
  }
}
