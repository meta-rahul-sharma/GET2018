import { sayHello } from './modules/greeting';
import { sum } from './modules/math-functions';

const resultGreeting = document.getElementById('resultGreeting');
const resultSumFirst = document.getElementById('resultSumFirst');
const showSumFirst = document.getElementById('sumFirst');

const resultSumSecond = document.getElementById('resultSumSecond');
const showSumSecond = document.getElementById('sumSecond');

resultGreeting.textContent = sayHello('Nice to see you! 😂');

resultSumFirst.style.display = 'none';
resultSumSecond.style.display = 'none';

const a = 3;
const b = 2;

showSumFirst.addEventListener('click', function () {
    resultSumFirst.style.display = 'block';
    resultSumFirst.textContent = `The sum of (${a}, ${b} ) is ${sum(a, b)}. ✨`;
});

showSumSecond.addEventListener('click', function () {
    resultSumSecond.style.display = 'block';
    resultSumSecond.textContent = `The sum of (${a})(${b}) is ${sum(a)(b)}. ✨`;
});
