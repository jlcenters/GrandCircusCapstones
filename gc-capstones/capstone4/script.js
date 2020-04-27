let store = [ {name : "juice",cost : 1,taxable : true},
{name : "milk",cost : 1.99,taxable : true},
{name : "eggs",cost : 1.99,taxable : true}
];
let cart = [];
let items = document.querySelector(".items");


let showStore = document.getElementById("showStore");
showStore.addEventListener("click",(event) =>{
	getList(store);
});

let showCart = document.getElementById("showCart");
showCart.addEventListener("click",(event) =>{
	getList(cart);
});
function addToCart(item){
	cart.push(JSON.stringify(item));
}
function removeFromCart(index,item){
	console.log(JSON.stringify(cart));
	//cart = cart.filter(cart[index] !== cart.indexOf(JSON.stringify(item));
	console.log(JSON.stringify(cart));
}

function getList(list){
	for (let item of list) {
		if(list === store){
			items.insertAdjacentHTML("beforeend", "<tr><td></td><td><p>" + JSON.stringify(item.name)
			+ "</p></td> <td><p>$" + JSON.stringify(item.cost) + "</p></td> <td><p>"
			+ JSON.stringify(item.taxable) + "</p></td><td><button type='button' onclick='addToCart(" + JSON.stringify(item) +")'>Add to Cart</button></td></tr>");
			console.log(JSON.stringify(item));
		}else{
			checkout.insertAdjacentHTML("beforeend", "<tr><td></td><td><p>" + JSON.stringify(item.name)
					+ "</p></td> <td><p>$" + JSON.stringify(item.cost) + "</p></td> <td><p>"
					+ JSON.stringify(item.taxable) + "</p></td><td><button list.indexOf( type='button' onclick='removeFromCart(" + list.indexOf(JSON.stringify(item),JSON.stringify(item)) +")'>Add to Cart</button></td></tr>");
					console.log(JSON.stringify(item));
		}
	}
}
/*
 * <tr> <td></td> <td></td> <td></td> </tr>
 */
