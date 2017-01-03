/**
 * @author denis
 */
function showTable(key) {
	switch (key) {
	case 1:
		document.getElementById("users-table").hidden = false;
		document.getElementById("courses-table").hidden = true;
		document.getElementById("groups-table").hidden = true;
		document.getElementById("data-groups-table").hidden = true;
		break;
	case 2:
		document.getElementById("users-table").hidden = true;
		document.getElementById("courses-table").hidden = false;
		document.getElementById("groups-table").hidden = true;
		document.getElementById("data-groups-table").hidden = true;
		break;
	case 3:
		document.getElementById("users-table").hidden = true;
		document.getElementById("courses-table").hidden = true;
		document.getElementById("groups-table").hidden = false;
		document.getElementById("data-groups-table").hidden = true;
		break;
	case 4:
		document.getElementById("users-table").hidden = true;
		document.getElementById("courses-table").hidden = true;
		document.getElementById("groups-table").hidden = true;
		document.getElementById("data-groups-table").hidden = false;
		break;
	}

}