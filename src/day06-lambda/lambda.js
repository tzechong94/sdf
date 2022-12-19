let hello = function(name) {
    console.log(`hello ${name}`)
}

const username = 'fred'
const hi = hello
const names = [ 'fred', 'betty', 'barney', 'wilma']

const sayHello = function(fn, args) {
    fn(args)
}

console.log('>>> hello: ', hello)
hello(username)

sayHello(hello,'wilma')
console.info('say hello to these guys ', names)
for (let n of names) {
    sayHello(hello, n)
}
