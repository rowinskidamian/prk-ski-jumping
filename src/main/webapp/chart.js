
let label = document.querySelectorAll(".chart-label");
let points = document.querySelectorAll(".chart-points");
let ctx = document.getElementById('myChart').getContext('2d');
let labels = [];
let values = [];

ctx.canvas.width = 600;
ctx.canvas.height = 400;

for (let i = 0; i < label.length; i++) {
    labels = [...labels, label[i].innerHTML];
    values = [...values, parseInt(points[i].innerHTML)];
}

let myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: [...labels],
        datasets: [{
            data: [...values],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        },
        plugins: {
            legend: {
                display: false
            }
        }
    }
});




