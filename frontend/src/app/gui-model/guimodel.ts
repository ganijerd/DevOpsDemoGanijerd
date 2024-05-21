/* tslint:disable:max-line-length */
export class GuiModel {

    private _guiModel = {
        "application": {
            "title": "DevOpsDemo Ganijerd FS2024",
            "formList": [
                {
                    "id": "OwnUserForm",
                    "title": "NotImplemented",
                    "formFieldList": [
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "NotImplementedForm",
                    "title": "Not Implemented",
                    "url": "/dummyform",
                    "headerVisible": false,
                    "footerVisible": false,
                    "borderStyle": "None",
                    "formFieldList": [
                        {
                            "id": "NotImplemented",
                            "type": "label",
                            "name": "NotImplementedMessage",
                            "width": 2
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "NotImplementedFormModal",
                    "title": "NotImplemented",
                    "url": "/dummyform",
                    "formFieldList": [
                        {
                            "id": "NotImplemented",
                            "type": "label",
                            "name": "NotImplementedMessage",
                            "width": 2
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "ToDoForm",
                    "title": { default: "ToDo" },
                    "url": "/todo",
                    "formFieldList": [
                        {
                            "id": "title",
                            "type": "text",
                            "name": { default: "Titel" },
                            "required": true,
                            "width": 2
                        },
                        {
                            "id": "description",
                            "type": "text",
                            "name": { default: "Text" },
                            "newRow": true,
                            "maxLength": 4000,
                            "height": 4,
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "ModuleForm",
                    "title": { default: "Neue Kachel" },
                    "formFieldList": [
                        {
                            "id": "firstName",
                            "type": "text",
                            "name": { default: "Vorname" },
                            "required": true,
                        },
                        {
                            "id": "lastName",
                            "type": "text",
                            "name": { default: "Nachname" },
                            "required": true,
                        },
                        {
                            "id": "country",
                            "type": "text",
                            "name": { default: "Herkunftsland" },
                            "newRow": true,
                        },
                        {
                            "id": "age",
                            "type": "text",
                            "name": { default: "Alter" },
                            "required": true,
                        },
                        {
                            "type": "cancelButton",
                            "name": {default : "Abbrechen"},
                        },
                        {
                            "type": "okButton",
                            "name": {default : "Erstellen"},
                        },

                    ]//___________________________________
                },
            ],
            "pageList": [
                {
                    "id": "mainmenu",
                    "name": "MainMenu",
                    "elementList": [
                        {
                            "type": "pageLabel",
                            "value": "<h4>Willkommen bei DevOps</h4>",
                            "newRow": true
                        },
                        {
                            "type": "button",
                            "name": { default: "ToDo-List" },
                            "icon": "fa-file-alt",
                            "color": "wet-asphalt",
                            "page": "toDoPage",
                            "width": 2,
                            "newRow": true,
                        },
                        // Neuer Button erstellt "Person hinzufügen"
                        //______________________________________________
                        {
                            "type": "newButton",
                            "name": { default: "Neue Person hinzufügen" },
                            "icon": "fa-plus",
                            "color": "green",
                            "width": 2,
                            "form": {
                                "form": "ModuleForm"
                            }
                        },
                       
                    ]
                },
                {
                    "id": "toDoPage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": { default: "Neues ToDo" },
                            "icon": "fa-user",
                            "color": "green",
                            "width": 2,
                            "form": {
                                "form": "ToDoForm"
                            }
                        },
                        {
                            "type": "list",
                            "name": "ToDo",
                            "icon": "fa-user",
                            "color": "wet-asphalt",
                            "search": true,
                            "url": "/todo",
                            "form": {
                                "form": "ToDoForm"
                            }
                        }
                    ]
                },
                {
                    "id": "ModulePage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "list",
                            "name": "Module",
                            "icon": "fa-user",
                            "color": "wet-asphalt",
                            "search": true,
                            "url": "/module",
                            "form": {
                                "form": "ModuleForm"
                            }
                        }
                    ]
                },

            ]
        }
    };


    get guiModel() {
        return this._guiModel;
    }
}
