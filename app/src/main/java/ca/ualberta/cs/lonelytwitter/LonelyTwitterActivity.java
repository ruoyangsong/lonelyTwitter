package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is the main view class of the project.<tr>In this class, user interact
 * and file manipulation is performed.
 * All files are the form of jason file that are stored in Emulator's access
 * <pre>
 *     pre-fromatted text;<br>
 *         File Explore->data->ca.ualberta.lonelytwitter->file->file.sav
 * </pre>
 * <code> begin <br>
 * some presudo code<br>
 * end.</code>
 * This file name is indicate in the $nbsp $nbsp $nbsp FILENAME constant.
 * <ul>
 * <li>item 1</l1>
 * <li>item 2</l1>
 * <li>item 3</l1>
 * </ul>
 * <ol>
 * <li>item 1</l1>
 * <li>item 2</l1>
 * <li>item 3</l1>
 * </ol>
 *
 * @author ruoyang
 * @version 1.0
 * @see Tweet
 * @since 0.5
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweet are saved there.The format of the file is JSON.
	 * @see #loadFromFile()
	 * @see #saveInFile(String, Date)
	 */

	private static final String FILENAME = "2.sav";
	private enum TweetListOrding{
		/**
		 * Date ascening tweet list ording.
		 */
		DATE_ASCENING, /**
		 * Date descening tweet list ording.
		 */
		DATE_DESCENING, /**
		 * Text ascening tweet list ording.
		 */
		TEXT_ASCENING, /**
		 * Text descening tweet list ording.
		 */
		TEXT_DESCENING};

	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);



		try {
			Tweet tweet = new NormalTweet("First tweet");
			tweet.setMessage("asdfsa");
			ImportTweet importTweet = new ImportTweet("important");
			importTweet.getDate();

			NormalTweet normaltweet = new NormalTweet("im normal");
			ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
			arrayList.add(tweet);
			arrayList.add((Tweet)importTweet);
			arrayList.add(normaltweet);

		}catch(TweetToLong e){
			e.printStackTrace();
		}

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				try {
					Tweet tweet = new NormalTweet(text);
					tweetList.add(tweet);
					adapter.notifyDataSetChanged();
					saveInFile(text, new Date(System.currentTimeMillis()));
					//finish();
				}catch(TweetToLong e){

				}
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
		loadFromFile();


		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Trinmes extra sapces using regular expression.
	 * @param inputString string that needs to be cleaned of extra spaces
	 * @return return inputString
     */

	private String trimExtraspace(String inputString){
		inputString = inputString.replaceAll("\\s+"," ");
		return inputString;
	}

	/**
	 * This method sorts items in the tweet list and refreshes the adapter
	 * @param ording ording to be used
     */
	private void sortTweetListItems(TweetListOrding ording){

	}

	/**
	 * Loads tweet from specified file.
	 *
	 * @throws TweetToLong if the text is too long
	 * @exception FileNotFoundException if the file is not created first
	 */

	private void loadFromFile() {

		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//Taken from stackflow
			//2017-01-24 18:19
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}

	}


	/**
	 * save tweet to a sepcific file in JSON format.
	 * @throws FileNotFoundException if the file doesn't exist.
	 *
     */
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList,out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Handle the EXception properly later
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
