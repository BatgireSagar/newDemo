module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        conflict: '#ef4444', // red
        missing: '#f59e42', // yellow
        match: '#22c55e',   // green
      },
    },
  },
  plugins: [],
}