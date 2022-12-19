// Primitives - scalar type


const userName = "fred";
const age = 50;

//array, objects - reference type
let numList = [ 1, 2, 3, 4, 5 ]

// objects

let fred = {
    name: 'fred',
    age: 50
}

// function type -> greetings2 is a varible. can assign another variable to ref its value
let greetings2 = function(name) {
    console.log(`Hello ${name}`)
}

const greetings1 = (name) => {
    console.log(`Hello ${name}`)
}

function greetings(name) {
    console.log(`Hello ${name}`)
}

console.log(`name: ${userName}, age ${age}`)
console.info('numList ', numList)
console.info('fred ', fred)
greetings(userName)