from fastapi import FastAPI
from instaScrapping import scrape_instagram

app = FastAPI()


@app.get("/")
async def root():
    return {"message": "Hello World"}


@app.get("/hello/{name}")
async def say_hello(name: str):
    return {"message": f"Hello {name}"}

@app.get("/scrape")
async def scrape():
    result = scrape_instagram()
