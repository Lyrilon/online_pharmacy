# Online Pharmacy

This project demonstrates a minimal online pharmacy implemented with **Spring Boot**. It includes REST APIs for managing drugs and a simple chat interface that retrieves answers from local documents.

## Features
- Browse, search, add, update and delete example drugs
- Chat endpoint backed by local document search with conversation history
- Static HTML page for chatting with the backend

## Environment setup
1. **Install Java 21** and **Maven**. On Ubuntu:
   ```bash
   sudo apt-get update && sudo apt-get install -y openjdk-21-jdk maven
   ```
2. *(Optional)* Install Python dependencies for experimenting with the chat service:
   ```bash
   pip install -r requirements.txt
   ```

## Building
Maven will download dependencies on the first run (requires internet access). To build and run tests:
```bash
mvn test
```

## Running the application
Start the Spring Boot server with:
```bash
mvn spring-boot:run
```
The chat page will then be available at [http://localhost:8080/index.html](http://localhost:8080/index.html).

## API overview
- `GET /api/drugs` – list all drugs
- `GET /api/drugs/{id}` – retrieve a drug by id
- `GET /api/drugs/search?q=term` – search drugs
- `POST /api/drugs` – add a new drug (JSON body)
- `PUT /api/drugs/{id}` – update an existing drug
- `DELETE /api/drugs/{id}` – remove a drug
- `POST /api/chat` – ask a question
- `GET /api/chat/history` – retrieve chat history

## Testing the chat
Try asking questions found in `src/main/resources/documents/drug_info.txt`. The service searches these files for relevant lines and stores the conversation in memory.
