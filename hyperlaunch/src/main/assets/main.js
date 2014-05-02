window.onload = function () {
	apps = JSON.parse(Launcher.apps());

	var list = document.querySelector('ul'),
		fragment = document.createDocumentFragment(),
		len = apps.length,
		li, button, i;

	for (i = 0; i < len; i++) {
		li = document.createElement('li');
		button = document.createElement('button');
		button.textContent = apps[i].launchName;
		button.dataset.packageName = apps[i].packageName;
		var packageName = apps[i].packageName;
		button.onclick = launchApp;
		li.appendChild(button);
		fragment.appendChild(li);
	};

	list.appendChild(fragment);
}

function launchApp () {
	console.log(this);
	Launcher.launch(this.dataset.packageName);
}