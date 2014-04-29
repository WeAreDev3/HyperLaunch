window.onload = function () {
	// console.log(Launcher.apps())
	var apps = JSON.parse(Launcher.apps());

	var list = document.querySelector('ul');

	for (var i = 0; i < apps.length; i++) {
		var li = document.createElement('li');
		li.textContent = apps[i].launchName;
		list.appendChild(li);
	};
}