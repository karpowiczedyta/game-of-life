export async function getNextStep(cells) {
  const fetchData = async () => {
    const result = await fetch(`http://localhost:8080/next-step`, {
      method: "POST",
      body: JSON.stringify(cells),
      headers: {
        "Content-Type": "application/json",
      },
    });
    if (result.ok) {
      return await result.json();
    } else {
      alert("An error has occured!");
    }
  };
  return fetchData();
}
