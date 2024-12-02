<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sorting Algorithm Interface</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body class="bg-gray-100">
<div class="min-h-screen flex items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-lg w-96">
        <h1 class="text-2xl font-bold text-center mb-6">Sorting Algorithm</h1>

        <div class="mb-6">
            <label class="block text-gray-700 text-sm font-bold mb-2">Numbers Input</label>
            <input type="text"
                   id="numbersInput"
                   class="shadow border rounded w-full py-2 px-3 text-gray-700 focus:outline-none focus:shadow-outline"
                   placeholder="Enter numbers (e.g., 1,5,6,3,2)"
                   required>
        </div>

        <div class="mb-6">
            <label class="block text-gray-700 text-sm font-bold mb-2">Algorithm</label>
            <select id="algorithmSelect"
                    class="shadow border rounded w-full py-2 px-3 text-gray-700 focus:outline-none focus:shadow-outline">
                <option value="heap-sort">Heap Sort</option>
                <option value="quick">Quick Sort</option>
                <option value="merge">Merge Sort</option>
                <option value="bubble">Bubble Sort</option>
            </select>
        </div>

        <div class="mb-6">
            <label class="block text-gray-700 text-sm font-bold mb-2">Sort Order</label>
            <div class="flex justify-around">
                <label class="inline-flex items-center">
                    <input type="radio" id="ascRadio" name="order" value="asc" checked>
                    <span class="ml-2">Ascending</span>
                </label>
                <label class="inline-flex items-center">
                    <input type="radio" id="descRadio" name="order" value="desc">
                    <span class="ml-2">Descending</span>
                </label>
            </div>
        </div>

        <div class="flex justify-center">
            <button type="button"
                    onclick="sortNumbers()"
                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                Sort
            </button>
        </div>

        <div class="mt-6 p-4 bg-gray-100 rounded">
            <h2 class="font-bold mb-2">Result:</h2>
            <p id="resultDisplay">No result to display yet.</p>
        </div>
    </div>
</div>

<script>
    function sortNumbers() {
        const numbersInput = document.getElementById('numbersInput').value.trim();
        const algorithmSelect = document.getElementById('algorithmSelect').value;
        const ascRadio = document.getElementById('ascRadio').checked;
        const descRadio = document.getElementById('descRadio').checked;

        const formData = {
            array: numbersInput,
             algorithm: algorithmSelect,
            order: ascRadio ? 'asc' : 'desc'
        };

        axios.post(`http://localhost:8081/springProject/sort/`, formData)
            .then(response => {
                document.getElementById('resultDisplay').textContent = response.data;
            })
            .catch(error => {
                console.error('Error:', error);
                document.getElementById('resultDisplay').textContent = 'Error occurred while sorting.';
            });
    }
</script>
</body>
</html>